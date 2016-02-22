<html lang="es">
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
		<link href="css/editor.css" type="text/css" rel="stylesheet"/>
		
</head>
<body>

<form id="form" name="form" method="post">
<div class="col-lg-12 nopadding">
<textarea id="txtEditor" name="txtEditor"></textarea>
<textarea id="txtEditorContent" name="txtEditorContent"></textarea>
<div class="well" id="preview"></div>
</div>
<input type="button" id="s2" value="Go">
</form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
                <script src="js/editor.js"></script>
<script language="javascript" type="text/javascript">

$(document).ready( function() {
$("#txtEditor").Editor();

$("#s2").click(function(){
$('#txtEditorContent').text($('#txtEditor').Editor("getText",["<button>"]));
$('#preview').append($('#txtEditorContent').val());
});

});
</script>
</body>
</html>