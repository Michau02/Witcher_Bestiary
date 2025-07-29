import {capitalize, humanize} from '/js/utils/string-utils.js';

let container;

// Initializes the page after DOM is loaded:
// - Fetches item data from API
// - Updates the document title and title bar
// - Renders item properties or shows error if not found
document.addEventListener("DOMContentLoaded", () => {

    container = document.getElementById("properties-container");

    const parts = window.location.href.split("/");
    const id = parts.at(-1);
    const type = parts.at(-2);

    if (!id) {
        document.body.innerHTML = `<p>Item doesn't exist</p>`;
        return;
    }

    fetch(`/api/${type}/${id}`)
        .then(response => {
            if (!response.ok) throw new Error("Couldn't fetch data");
            return response.json();
        })
        .then(data => {
            const capitalizedName = capitalize(data["name"]);
            document.getElementById("title-text").textContent =
                capitalize(type.slice(0, -1)).concat(" ➡️ ", capitalizedName);
            document.title = capitalizedName;
            console.log("to sie zrobilo?");

            renderProperties(data);
            console.log("a to nie? XD");
        })
        .catch(error => {
            document.body.innerHTML = `<p>Error: ${error.message}</p>`;
        });
});

/**
 * Renders item details by populating the DOM with data fetched from the API.
 *
 * Creates property boxes appended to the container.
 *
 * @param {Object.<string, any>} data - Object containing item properties.
 */
function renderProperties(data) {

    // item properties
    for (let key in data) {
        // box
        const myBox = document.createElement("div");
        myBox.classList.add("property-box")

        // header
        const myHeader2 = document.createElement("h2");
        myHeader2.textContent = humanize(key);
        myBox.appendChild(myHeader2);

        // property
        const property = data[key];

        // property as an array
        if (Array.isArray(property) && property.length > 0) {
            //for...
        }
        // property not an array
        else {
            const valueLabel = document.createElement("label");
            console.log(property, typeof property);
            valueLabel.textContent = capitalize(property.toString());
            console.log("po");
            myBox.appendChild(valueLabel);
        }

        container.appendChild(myBox);
    }
}