function $(str) {
    return document.getElementById(str);
}
 
var addrShow = $('addr-show');
var btn = document.getElementsByClassName('met1')[0];
var prov = $('address_province');
var city = $('address_city');
var country = $('address_area');


var current = {
    prov: '',
    city: '',
    country: ''
};

function showProv() {
     prov = document.getElementById('address_province');
     city = document.getElementById('address_city');
     country = document.getElementById('address_area');
    // btn.disabled = true;
    var len = provice.length;
    for (var i = 0; i < len; i++) {
        var provOpt = document.createElement('option');
        provOpt.innerText = provice[i]['name'];
        provOpt.value = i;
        prov.appendChild(provOpt);
    }
};

function showCity(obj) {
   // alert("hah");
    document.getElementById("address_area").textContent="";
    if(obj.selectedIndex==null||obj.selectedIndex==""){
        document.getElementById("address_city").textContent="";
        document.getElementById("address_area").textContent="";
    }else {
        var val = obj.options[obj.selectedIndex].value;
        if (val != current.prov) {
            current.prov = val;
            // addrShow.value = '';
            // btn.disabled = true;
        }
        //console.log(val);
        if (val != null) {
            city.length = 1;
            var cityLen = provice[val]["city"].length;
            for (var j = 0; j < cityLen; j++) {
                var cityOpt = document.createElement('option');
                cityOpt.innerText = provice[val]["city"][j].name;
                cityOpt.value = j;
                city.appendChild(cityOpt);
            }
        }
    }
};

function showCountry(obj) {
    if (obj.selectedIndex == null || obj.selectedIndex == "") {
        document.getElementById("address_area").textContent="";
    } else {

    var val = obj.options[obj.selectedIndex].value;
    current.city = val;
    if (val != null) {
        country.length = 1;
        var countryLen = provice[current.prov]["city"][val].districtAndCounty.length;
        // if (countryLen == 0) {
        //     // addrShow.value = provice[current.prov].name + '-' + provice[current.prov]["city"][current.city].name;
        //     return;
        // }
        for (var n = 0; n < countryLen; n++) {
            var countryOpt = document.createElement('option');
            countryOpt.innerText = provice[current.prov]["city"][val].districtAndCounty[n];
            countryOpt.value = n;
            country.appendChild(countryOpt);
        }
    }
}
}


function selecCountry(obj) {
    current.country = obj.options[obj.selectedIndex].value;
    if ((current.city != null) && (current.country != null)) {
        // btn.disabled = false;
    }
}


// function showAddr() {
//     addrShow.value = provice[current.prov].name + '-' + provice[current.prov]["city"][current.city].name + '-' + provice[current.prov]["city"][current.city].districtAndCounty[current.country];
// }
