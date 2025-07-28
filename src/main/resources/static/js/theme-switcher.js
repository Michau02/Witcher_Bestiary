let switcher;

document.addEventListener("DOMContentLoaded", () => {
    const savedTheme = localStorage.getItem("theme") || "dark";
    document.body.classList.add(`${savedTheme}-theme`);

    const labels = document.querySelectorAll(".theme-switcher label");
    const themeRadios = document.querySelectorAll('input[name="theme"]');

    themeRadios.forEach(radio => {
        if (radio.value === savedTheme) {
            radio.checked = true;
        }

        radio.addEventListener("change", () => {
            const selected = radio.value;
            document.body.classList.remove("light-theme", "dark-theme");
            document.body.classList.add(`${selected}-theme`);
            localStorage.setItem("theme", selected);

            labels.forEach(label => label.classList.remove("checked"));
            radio.closest("label").classList.add("checked");
        });
    });
});