function toggleNav() {
    let x = document.getElementById("top-nav")
    if (x.className === "nav") {
        x.className += " active"
    } else {
        x.className = "nav";
    }
}

function validatePassWordConfirm() {
    let x = document.forms["register-form"]["password"].value;
    let y = document.forms["register-form"]["confPassword"].value;
    console.log(x, y);
    if (x !== y) {
        console.log("x khác y");
        document.getElementById("mess_error_register").innerHTML = "Password not match! Please try again!";
        return false;
    } else document.getElementById("mess_error_register").innerHTML = "";
}

window.onscroll = function () {
    scrollFunction()
};

function topFunction() {
    document.body.scrollTop = 0; // For Safari
    document.documentElement.scrollTop = 0;
}

mybutton = document.getElementById("myBtn-scroll-top");

function scrollFunction() {
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        mybutton.style.display = "block";
    } else {
        mybutton.style.display = "none";
    }
};

myImageUpFirebase = document.getElementById("image-up-firebase");
myImagePreviewUpFirebase = document.getElementById("image-preview-up-firebase");

myImageUpFirebase.onchange = evt => {
    const [file] = myImageUpFirebase.files;
    if (file) {
        myImagePreviewUpFirebase.src = URL.createObjectURL(file)
    }
}

myStorage = document.getElementById("store-url-firebase");


if (document.querySelector("#firebase-trigger-update-product") === null || document.querySelector("#firebase-trigger-update-product") === undefined) {}
else{
    document.querySelector("#firebase-trigger-update-product").addEventListener("click", async function (event) {
        event.preventDefault();
        console.log('update');
        let form = document.getElementById('wtfloihoai');
        if (myImageUpFirebase.files[0] === undefined) {
            for (let i = 0; i < form.elements.length; i++) {
                if (form.elements[i].value === '' && form.elements[i].hasAttribute('required')
                    && form.elements[i].getAttribute('id') !== "image-up-firebase") {
                    alert('There are some required fields!');
                    return false;
                }
            }
            form.submit();
        } else {
            const file = myImageUpFirebase.files[0];
            const metadata = {
                contentType: file.type
            };
            for (let i = 0; i < form.elements.length; i++) {
                if (form.elements[i].value === '' && form.elements[i].hasAttribute('required')) {
                    alert('There are some required fields!');
                    return false;
                }
            }
            const ref = firebase.storage().ref();
            const name = file.name;
            const up = ref.child(name).put(file, metadata);

            await up.then(snapshot => snapshot.ref.getDownloadURL())
                .then(url => {
                    myStorage.value = url;
                })
                .catch(console.error)

            form.submit();
        }
    }, false);

}
if (document.querySelector("#firebase-trigger") === null && document.querySelector("#firebase-trigger") === undefined) {}
else {
    document.querySelector("#firebase-trigger").addEventListener("click", async function (event) {
        event.preventDefault();
        console.log('add');

        let form = document.getElementById('wtfloihoai');
        for (let i = 0; i < form.elements.length; i++) {
            if (form.elements[i].value === '' && form.elements[i].hasAttribute('required')) {
                alert('There are some required fields!');
                form.element[i].scrollTop();
                return false;
            }
        }
        if (myImageUpFirebase.files[0] === undefined) {
        } else {
            const file = myImageUpFirebase.files[0];
            const metadata = {
                contentType: file.type
            };
            const ref = firebase.storage().ref();
            const name = file.name;
            const up = ref.child(name).put(file, metadata);

            await up.then(snapshot => snapshot.ref.getDownloadURL())
                .then(url => {
                    myStorage.value = url;
                })
                .catch(console.error)
        }
        form.submit();
    }, false);
}

function validateChange() {
    let x = document.forms["change-password-form"]["password"].value;
    let y = document.forms["change-password-form"]["confPassword"].value;
    console.log(x, y);
    if (x !== y) {
        console.log("x khác y");
        document.getElementById("mess_error_change_password").innerHTML = "Password not match! Please try again!";
        return false;
    } else document.getElementById("mess_error_change_password").innerHTML = "";
}

function alertFeatureUpdate() {
    alert("Opps! Tính năng đang được cập nhập! Vui lòng thử lại sau!")
}

function handleFilterBrand(brandId) {
    console.log(brandId);
    if (brandId === "all") {
        document.forms["quaTroiNan"]["brand_id"].value = null;
        document.forms["quaTroiNan"].submit();
    } else {
        document.forms["quaTroiNan"]["brand_id"].value = brandId;
        document.forms["quaTroiNan"].submit();
    }
}
function handleAddWith(url){
    let xmlHttp = new XMLHttpRequest();
    console.log("onclick");
    console.log(url);
    xmlHttp.open( "GET", url, true ); // false for synchronous request
    xmlHttp.send( null );
    location.reload();
}

