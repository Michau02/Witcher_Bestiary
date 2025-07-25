const itemCategories = {
    alchemy: ['potions', 'bombs', 'elixirs', 'oils', 'decoctions'],
    armoury: ['gloves', 'shoes', 'helmets'], // to be filled
    weapons: ['swords', 'axes'] // to be filled
    // to be filled
};

document.addEventListener("DOMContentLoaded", () => {
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
    const table = document.getElementById("items-table");
    if (!Array.isArray(data) || data.length === 0) {
        table.innerHTML = "<tr><td>No found items to display</td></tr>";
        return;
    }


    const keys = Object.keys(data[0]);
    const thead = document.createElement("thead");
    const headRow = document.createElement("tr");
    keys.forEach(key => {
        const th = document.createElement("th");
        th.textContent = formatHeader(key);
        headRow.appendChild(th);
    });
    thead.appendChild(headRow);
    table.appendChild(thead);


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
    table.appendChild(tbody);
}

function formatHeader(key) {
    return key.replace(/([A-Z])/g, " $1")
        .replace(/^./, str => str.toUpperCase());
}