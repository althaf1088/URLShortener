// The following example creates a marker in Stockholm, Sweden
// using a DROP animation. Clicking on the marker will toggle
// the animation between a BOUNCE animation and no animation.

var stockholm = new google.maps.LatLng(59.32522, 18.07002);
var parliament = new google.maps.LatLng(59.327383, 18.06747);
var markers = [];
var somes = [];
var geocoder;
var marker;
var map;

function initialize() {
    geocoder = new google.maps.Geocoder();
    var mapOptions = {
        zoom: 5
    };

    map = new google.maps.Map(document.getElementById('map-canvas'),
            mapOptions);

//    marker = new google.maps.Marker({
//        map: map,
//        draggable: true,
//        animation: google.maps.Animation.DROP,
//        position: parliament
//    });
//    google.maps.event.addListener(marker, 'click', toggleBounce);
}

function toggleBounce() {

    if (marker.getAnimation() !== null) {
        marker.setAnimation(null);
    } else {
        marker.setAnimation(google.maps.Animation.BOUNCE);
    }
}

function lolo(addr) {
//    if (markers.length < 15 && somes.indexOf(addr.substr(0, 6)) < 0) {

//                console.log(addr);
        geocoder.geocode({
            'address': addr
        },
        function(results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                map.setCenter(results[0].geometry.location);
                var marker = new google.maps.Marker({
                    animation: google.maps.Animation.DROP,
                    map: map,
                    position: results[0].geometry.location
                });
                google.maps.event.addListener(marker, 'click', toggleBounce);
                markers.push(marker);
//                somes.push(addr.substr(0, 6));
//                console.log(addr);
            }
        });
    }
//}

google.maps.event.addDomListener(window, 'load', initialize);
