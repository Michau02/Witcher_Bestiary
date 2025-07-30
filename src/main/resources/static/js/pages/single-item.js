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

            renderProperties(data);
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
        if (Array.isArray(property) && key === "ingredients") {
            for (let p of property) {
                try {
                    const quantity = p["quantity"]?.toString() ?? "???";
                    const ingredient = p["ingredient"];
                    const name = ingredient?.name?.toString() ?? "Unknown";
                    const ingredientId = ingredient?.id;

                    const valueLabel = document.createElement("label");

                    if (ingredientId) {
                        const link = document.createElement("a");
                        link.href = `/ingredients/id/${ingredientId}`; // controller not implemented yet - final url should be something like this: /api/ingredients/id/${ingredientId}
                        link.textContent = name;
                        link.style.color = "inherit";
                        link.style.textDecoration = "underline";
                        valueLabel.textContent = `- ${quantity}x `;
                        valueLabel.appendChild(link);
                    } else {
                        valueLabel.textContent = `- ${quantity}x ${name}`;
                    }
                    myBox.appendChild(valueLabel);
                } catch (e) {
                    console.error("Something went wrong with ingredient processing: ", e);
                    const errorLabel = document.createElement("label");
                    errorLabel.textContent = "- Unknown due to an error";
                    errorLabel.style.color = "red";
                    myBox.appendChild(errorLabel);
                }
            }
        }
        // property not an array
        else {
            const valueLabel = document.createElement("label");
            valueLabel.textContent = capitalize(property.toString());
            myBox.appendChild(valueLabel);
        }

        container.appendChild(myBox);
    }
}