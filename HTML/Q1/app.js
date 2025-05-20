document.querySelectorAll('nav a').forEach(link => {
  link.addEventListener('click', function(e) {
    e.preventDefault();
    const target = this.getAttribute('href').replace('#', '');
    document.querySelectorAll('.spa-section').forEach(sec => sec.style.display = 'none');
    document.getElementById(target).style.display = 'block';
  });
});
document.getElementById('home').style.display = 'block';
