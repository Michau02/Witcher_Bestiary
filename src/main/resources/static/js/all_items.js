const itemCategories = {
    alchemy: ['potions', 'bombs', 'elixirs', 'oils', 'decoctions'],
    armoury: ['gloves', 'shoes', 'helmets'], // to be filled
    weapons: ['swords', 'axes'] // to be filled
    // to be filled
};

let table;

let currentData = [];
let currentSort = {
    key: null,
    direction: 'asc' // or 'desc'
};

document.addEventListener("DOMContentLoaded", () => {
    //for theme switching
    const theme = localStorage.getItem("theme") || "dark";
    document.body.classList.add(theme);

    table = document.getElementById("items-table");
    const type = window.location.href.split('/').at(-1)

    if (!type) {
        document.body.innerHTML = "<p>Brak typu przedmiotu w URL. Użyj ?type=potions</p>";
        return;
    }

    document.title = `${type.at(0).toUpperCase() + type.slice(1)} list`;
    document.getElementById("title-text").textContent =
        `${type.at(0).toUpperCase() + type.slice(1)} items`;

    for (const [category, items] of Object.entries(itemCategories)) {
        if (items.includes(type)) {
            document.body.style.backgroundImage = `url('/img/${category}.webp')`;
            break;
        }
    }

    fetch(`/api/${type}/dto`)
        .then(response => {
            if (!response.ok) throw new Error("Couldn't fetch data");
            return response.json();
        })
        .then(data => renderTable(data, type))
        .catch(error => {
            document.body.innerHTML = `<p>Error: ${error.message}</p>`;
        });
});

function renderTable(data, type) {
    currentData = data;
    table.innerHTML = "";

    if (!Array.isArray(data) || data.length === 0) {
        table.innerHTML = "<tr><td>No found items to display</td></tr>";
        return;
    }

    const keys = Object.keys(data[0]);
    const thead = document.createElement("thead");
    const headRow = document.createElement("tr");
    keys.forEach(key => {
        const th = document.createElement("th");
        th.style.cursor = "pointer";
        th.onclick = () => sortList(key);
        th.textContent = formatHeader(key);
        headRow.appendChild(th);
    });
    thead.appendChild(headRow);
    table.appendChild(thead);

    renderTableBody(data, keys, type, table);
}

function renderTableBody(data, keys, type) {
    const tbody = document.createElement("tbody");

    data.forEach(item => {
        const row = document.createElement("tr");
        row.style.cursor = "pointer";
        row.onclick = () => window.location.href = `/alchemy/${type}/${item.id}`;

        keys.forEach(key => {
            const td = document.createElement("td");
            td.textContent = item[key];
            row.appendChild(td);
        });

        tbody.appendChild(row);
    });

    const oldTbody = table.querySelector("tbody");
    if (oldTbody) oldTbody.remove();

    table.appendChild(tbody);
}

function formatHeader(key) {
    return key.replace(/([A-Z])/g, " $1")
        .replace(/^./, str => str.toUpperCase());
}

function sortList(key) {
    console.log("SHOULD SORT");
    if (currentSort.key === key) {
        currentSort.direction = currentSort.direction === "asc" ? "desc" : "asc";
    } else {
        currentSort.key = key;
        currentSort.direction = "asc";
    }

    const dir = (currentSort.direction) === "asc" ? 1 : -1;
    const sorted = [...currentData].sort((a, b) => {
        const valA = a[key];
        const valB = b[key];


        if (typeof valA === "string" && typeof valB === "string") {
            return valA.localeCompare(valB) * dir;
        }
        if (valA > valB) {
            return dir;
        } else if (valA < valB) {
            return -1 * dir;
        } else {
            return 0;
        }
    })
    renderTableBody(sorted, Object.keys(currentData[0]), currentSort.key.split('.')[0]);
}

document.addEventListener("keypress", (event) => {
    console.log("KEY");
    if (event.key === "Enter") {
        console.log(("ENTER"))
        const currentTheme = document.body.classList.contains("dark-theme") ? "dark" : "light";
        const newTheme = currentTheme === "dark" ? "light" : "dark";

        document.body.classList.remove(`${currentTheme}-theme`);
        document.body.classList.add(`${newTheme}-theme`);
        localStorage.setItem("theme", newTheme);
    }
})