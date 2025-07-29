let container;

document.addEventListener("DOMContentLoaded", () => {

    container = document.getElementById("properties-container");

    const parts = window.location.href.split("/");
    const id = parts.at(-1);
    const type = parts.at(-2);

    fetch(`/api/${type}/${id}`)
        .then(response => {
            if (!response.ok) throw new Error("Couldn't fetch data");
            return response.json();
        })
        .then(data => renderProperties(data))
        .catch(error => {
            document.body.innerHTML = `<p>Error: ${error.message}</p>`;
        });
});

function renderProperties(data) {
    for (let key in data) {
        const header = document.createElement("label");
        header.innerText = key;
        header.classList.add("property-box")
        // (data[key].length > 1){
        //
        // }
        container.appendChild(header);
    }
}