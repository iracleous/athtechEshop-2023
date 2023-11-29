function createProduct() {
    var url = "http://localhost:8080/athtechEshop_war_exploded/api/product/";
    var method = "POST";
    var data = {
        name: document.getElementById("productName").value,
        price: Number(document.getElementById("productPrice").value)
    };

    fetch(url, {
        method: method, // *GET, POST, PUT, DELETE, etc.
        mode: "cors", // no-cors, *cors, same-origin
        cache: "no-cache", // *default, no-cache, reload, force-cache, only-if-cached
        credentials: "same-origin", // include, *same-origin, omit
        headers: {
            "Content-Type": "application/json",
            // 'Content-Type': 'application/x-www-form-urlencoded',
        },
        redirect: "follow", // manual, *follow, error
        referrerPolicy: "no-referrer", // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
        body: JSON.stringify(data), // body data type must match "Content-Type" header
        })
        .then(res => res.json())
        .then(d => {
            document.getElementById("resultDiv").innerHTML = JSON.stringify(d);
        })
        .catch(error => {
            if (error instanceof TypeError && error.message.includes('API key')) {
                console.error('Invalid API key:', error);
                document.getElementById("errorDiv").innerHTML = 'Invalid API key:' + error;
            } else {
                console.error('There was a problem with the Fetch operation:', error);
                document.getElementById("errorDiv").innerHTML = 'here was a problem with the Fetch operation:' + error;
            }
        });
}


function findProduct() {
    var url = "http://localhost:8080/athtechEshop_war_exploded/api/product/";
    var method = "GET";
    var productId =   Number(document.getElementById("productId").value);

    fetch(url+productId, {
        method: method, // *GET, POST, PUT, DELETE, etc.
        mode: "cors", // no-cors, *cors, same-origin
        cache: "no-cache", // *default, no-cache, reload, force-cache, only-if-cached
        credentials: "same-origin", // include, *same-origin, omit
        headers: {
            "Content-Type": "application/json",
            // 'Content-Type': 'application/x-www-form-urlencoded',
        },
        redirect: "follow", // manual, *follow, error
        referrerPolicy: "no-referrer" , // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
      //  body: JSON.stringify(data), // body data type must match "Content-Type" header
    })
        .then(res => res.json())
        .then(d => {
            document.getElementById("resultDiv").innerHTML = JSON.stringify(d);
        })
        .catch(error => {
            if (error instanceof TypeError && error.message.includes('API key')) {
                console.error('Invalid API key:', error);
                document.getElementById("errorDiv").innerHTML = 'Invalid API key:' + error;
            } else {
                console.error('There was a problem with the Fetch operation:', error);
                document.getElementById("errorDiv").innerHTML = 'here was a problem with the Fetch operation:' + error;
            }
        });
}


function getAllProduct() {

    var url = "http://localhost:8080/athtechEshop_war_exploded/api/product/";
    var method = "GET";


    fetch(url , {
        method: method, // *GET, POST, PUT, DELETE, etc.
        mode: "cors", // no-cors, *cors, same-origin
        cache: "no-cache", // *default, no-cache, reload, force-cache, only-if-cached
        credentials: "same-origin", // include, *same-origin, omit
        headers: {
            "Content-Type": "application/json",
            // 'Content-Type': 'application/x-www-form-urlencoded',
        },
        redirect: "follow", // manual, *follow, error
        referrerPolicy: "no-referrer" , // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
        //  body: JSON.stringify(data), // body data type must match "Content-Type" header
    })
        .then(res => res.json())
        .then(dataArray => {
            document.getElementById("resultDiv").innerHTML ="";

            dataArray.forEach(element =>
                document.getElementById("resultDiv").innerHTML += element.name+ "<br>"
            );
        })
        .catch(error => {
            if (error instanceof TypeError && error.message.includes('API key')) {
                console.error('Invalid API key:', error);
                document.getElementById("errorDiv").innerHTML = 'Invalid API key:' + error;
            } else {
                console.error('There was a problem with the Fetch operation:' );
                document.getElementById("errorDiv").innerHTML = 'here was a problem with the Fetch operation:' + error;
            }
        });







}

function changeProduct() {

}


function deleteProduct() {

}
