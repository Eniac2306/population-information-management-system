function $(str) {
    return document.getElementById(str);
}
 
var addrShow = $('addr-show');
var btn = document.getElementsByClassName('met1')[0];
var prov1 = $('address_province_A');
var city1 = $('address_city_A');
var country1 = $('address_area_A');


var current = {
    prov1: '',
    city1: '',
    country1: ''
};

function showProv1() {
     prov1 = document.getElementById('address_province_A');
     city1 = document.getElementById('address_city_A');
     country1 = document.getElementById('address_area_A');
    // btn.disabled = true;
    var len = provice.length;
    for (var i = 0; i < len; i++) {
        var provOpt = document.createElement('option');
        provOpt.innerText = provice[i]['name'];
        provOpt.value = i;
        prov1.appendChild(provOpt);
    }
};

function showCity1(obj) {
   // alert("hah");
    document.getElementById("address_area_A").textContent="";
    if(obj.selectedIndex==null||obj.selectedIndex==""){
        document.getElementById("address_city_A").textContent="";
        document.getElementById("address_area_A").textContent="";
    }else {
        var val = obj.options[obj.selectedIndex].value;
        if (val != current.prov1) {
            current.prov1 = val;
            // addrShow.value = '';
            // btn.disabled = true;
        }
        //console.log(val);
        if (val != null) {
            city1.length = 1;
            var cityLen = provice[val]["city"].length;
            for (var j = 0; j < cityLen; j++) {
                var cityOpt = document.createElement('option');
                cityOpt.innerText = provice[val]["city"][j].name;
                cityOpt.value = j;
                city1.appendChild(cityOpt);
            }
        }
    }
};

function showCountry1(obj) {
    if (obj.selectedIndex == null || obj.selectedIndex == "") {
        document.getElementById("address_area_A").textContent="";
    } else {

    var val = obj.options[obj.selectedIndex].value;
    current.city1 = val;
    if (val != null) {
        country1.length = 1;
        var countryLen = provice[current.prov1]["city"][val].districtAndCounty.length;
        // if (countryLen == 0) {
        //     // addrShow.value = provice[current.prov1].name + '-' + provice[current.prov1]["city1"][current.city1].name;
        //     return;
        // }
        for (var n = 0; n < countryLen; n++) {
            var countryOpt = document.createElement('option');
            countryOpt.innerText = provice[current.prov1]["city"][val].districtAndCounty[n];
            countryOpt.value = n;
            country1.appendChild(countryOpt);
        }
    }
}
}


function selecCountry1(obj) {
    current.country1 = obj.options[obj.selectedIndex].value;
    if ((current.city1 != null) && (current.country1 != null)) {
        // btn.disabled = false;
    }
}


// function showAddr() {
//     addrShow.value = provice[current.prov1].name + '-' + provice[current.prov1]["city1"][current.city1].name + '-' + provice[current.prov1]["city1"][current.city1].districtAndCounty[current.country1];
// }
