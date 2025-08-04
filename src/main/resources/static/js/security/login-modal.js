function openLoginPopup() {
    document.getElementById('loginModal').classList.add('visible');
}

function closeModal() {
    document.getElementById('loginModal').classList.remove('visible');
}

window.onclick = function (event) {
    const modal = document.getElementById('loginModal');
    if (event.target === modal) {
        modal.style.display = 'none';
    }
};