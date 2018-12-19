/**
 * Created by mohamed on 12/17/18.
 */

var lat = 5.36857;
var lng = -4.00179;
var map = null;

function initMap() {
    map = L.map('mapId').setView([lat, lng], 6);

    L.tileLayer('https://{s}.tile.openstreetmap.fr/osmfr/{z}/{x}/{y}.png', {
        attribution: 'données © <a href="//osm.org/copyright">OpenStreetMap</a>/ODbL - rendu ' +
        '<a href="//openstreetmap.fr">OSM Côte d\'ivoire</a>',
        minZoom: 1,
        maxZoom: 20
    }).addTo(map);
}
    window.onload = function(){
        initMap();
        handleEvent();
};

function handleEvent() {
    var marker;

    function onPopupOpen() {
        var tempMarker = this;
        // To remove marker on click of delete button in the popup of marker
        $(".marker-delete-button:visible").click(function () {
            map.removeLayer(tempMarker);
        });
    }

    function onMapClick(e) {
        var geojsonFeature = {
            "type": "Feature",
            "properties": {},
            "geometry": {
                "type": "Point",
                "coordinates": [e.latlng.lat, e.latlng.lng]
            }
        };

        L.geoJson(geojsonFeature, {
            pointToLayer: function(feature, latlng){
                marker = L.marker(e.latlng, {
                    title: e.latlng.toString(),
                    alt: e.latlng.toString(),
                    riseOnHover: true,
                    draggable: true
                }).bindPopup("<input type='button' value='Delete this marker' class='marker-delete-button'/>");

                marker.on("popupopen", onPopupOpen);
                return marker;
            }
        }).addTo(map);
    }

    function getAllMarkers() {
        var allMarkersGeoJsonArray = []; // for readable geoJson markers

        $.each(map._layers, function (ml) {
            if (map._layers[ml].feature) {
                allMarkersGeoJsonArray.push(this.toGeoJSON());
            }
        });

        if (allMarkersGeoJsonArray.length === 0)
            alert("Vous n'avez rien marqué comme point");
        else
            console.log(allMarkersGeoJsonArray);
    }
    
    function reloadMap() {
        window.location.reload();
    }

    // any html element such as button, div to call the function()
    $(".get-markers").on("click", getAllMarkers);
    $(".new-map").on("click", reloadMap);
    map.on('click', onMapClick);
}
