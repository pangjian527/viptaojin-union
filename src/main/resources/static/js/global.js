function menuSwitch(url){
    var menuElement = document.getElementById('menus');
    var lisElement = menuElement.getElementsByTagName("li");

    for(i=0;i<lisElement.length;i++){
    var aElement = lisElement[i].getElementsByTagName("a")[0];
    aElement.className = "";
    }

    this.getElementsByTagName("a")[0].className = "active";

    document.getElementById("iframe_content").src = url;
}

function clearForm(){
    var inputEles = document.getElementById("query").getElementsByTagName("input");
    var selectEles = document.getElementById("query").getElementsByTagName("select");

    for(var i = 0;i < selectEles.length;i++){
        selectEles[i].options[0].selected = true;
    }

    for(var i = 0;i < inputEles.length;i++){
        inputEles[i].value = "";
    }
}