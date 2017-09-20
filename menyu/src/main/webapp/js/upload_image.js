//@ sourceURL=campanha_insert.js

$(document).ready(function() {

	var uploadfiles = document.querySelector('#fileinput');
	uploadfiles.addEventListener('change', function() {
		var files = this.files;
		for (var i = 0; i < files.length; i++) {
			previewImage(this.files[i]);
		}
	}, false);
	/*
	 * uploadfiles.addEventListener('change', function() { for (var i = 0; i <
	 * this.files.length; i++) { var file = this.files[i]; // This code is only
	 * for demo ... console.group("File " + i); console.log("name : " +
	 * file.name); console.log("size : " + file.size); console.log("type : " +
	 * file.type); console.log("date : " + file.lastModified);
	 * console.groupEnd(); // uploadFile(this.files[i]); // call the function to
	 * upload the // file } }, false);
	 */
	$("#btn_uparimg").click(function() {
		fazerUp();
	});

});

function fazerUp() {
	var data = new FormData();

	jQuery.each(jQuery('#fileinput')[0].files, function(i, file) {
		data.append('file-' + i, file);
	});

	jQuery.ajax({
		url : 'imageup',
		data : data,
		cache : false,
		contentType : false,
		processData : false,
		type : 'POST',
		success : function(data) {

			if (data.msgok == 'ok') {
				sysMsg(data.msg, 'M')
				$.unblockUI();

			} else {
				$.unblockUI();
				sysMsg(data.erro, 'E')
			}

			$.unblockUI();

		},
		error : function(msg) {
			$.unblockUI();
		}
	});

}

function uploadFile(file) {
	var url = 'imageup';
	var xhr = new XMLHttpRequest();
	var fd = new FormData();
	xhr.open("POST", url, true);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			// Every thing ok, file uploaded
			console.log(xhr.responseText); // handle response.
		}
	};
	fd.append("upload_file", file);
	xhr.send(fd);
}

function previewImage(file) {
	var galleryId = "gallery";

	var gallery = document.getElementById(galleryId);
	var imageType = /image.*/;

	if (!file.type.match(imageType)) {
		throw "File Type must be an image";
	}

	var thumb = document.createElement("div");
	thumb.classList.add('thumbnail'); // Add the class thumbnail to the
	// created div

	var img = document.createElement("img");
	img.file = file;
	thumb.appendChild(img);
	gallery.appendChild(thumb);

	// Using FileReader to display the image content
	var reader = new FileReader();
	reader.onload = (function(aImg) {
		return function(e) {
			aImg.src = e.target.result;
		};
	})(img);
	reader.readAsDataURL(file);
}