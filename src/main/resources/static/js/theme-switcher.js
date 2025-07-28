let switcher;

document.addEventListener("DOMContentLoaded", () => {
    const savedTheme = localStorage.getItem("theme") || "dark";
    document.body.classList.add(`${savedTheme}-theme`);
    const themeRadios = document.querySelectorAll('input[name="theme"]');
    themeRadios.forEach(radio => {
        if (radio.value === savedTheme) radio.checked = true;
        console.log("ustawione");

        radio.addEventListener("change", () => {
            console.log("jest zmiana");
            const selected = radio.value;
            document.body.classList.remove("light-theme", "dark-theme");
            document.body.classList.add(`${selected}-theme`);
            localStorage.setItem("theme", selected);
        });
    });
});