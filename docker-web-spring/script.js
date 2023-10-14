document.addEventListener("DOMContentLoaded", function () {
    const automovilesDiv = document.getElementById("automoviles");

    fetch("[URL]") 
        .then(response => response.json())
        .then(data => {
            console.log(data);
            const automoviles = data;
            let html = "<ul>";

            automoviles.forEach(automovil => {
                html += `<li>Modelo: ${automovil.modelo}, Marca: ${automovil.marca}, Precio: ${automovil.precio}, Versión: ${automovil.version}</li>`;
            });

            html += "</ul>";
            automovilesDiv.innerHTML = html;
        })
        .catch(error => console.error("Error al consultar el servicio REST: " + error));
});
