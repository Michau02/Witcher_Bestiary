/**
 * Converts a camelCase string into a title-case form.
 *
 * Examples:
 *      "costOfCrafting" -> "Cost Of Crafting"
 *      "itemID" -> "Item ID"
 *
 * @param {string} text - The input to humanize.
 * @returns {string} The humanized string.
 */
export function humanize(text) {
    return text.replace(/([A-Z])/g, " $1")
        .replace(/^./, str => str.toUpperCase());
}

/**
 * Capitalizes the first character of a string.
 *
 * @param {string} text - The input string to capitalize.
 * @returns {string} The capitalized string.
 */
export function capitalize(text) {
    return text.at(0)
        .toUpperCase()
        .concat(text.slice(1));
}