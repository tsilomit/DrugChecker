/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
	$('#submit').click(function () {
		var content = $('#form').serialize();
		$.ajax({type: "post", url: "insertdb.jsp", data: content, success: function (msg) {
				var $text = $('<div style="text-align: left"></div>');
				$text.append('You have succesfully become a FarAway host!');
				BootstrapDialog.show({
					type: BootstrapDialog.TYPE_SUCCESS,
					title: 'Congratulations!',
					message: $text,
					closable: true,
					closeByBackdrop: false,
					closeByKeyboard: false,
					buttons: [
						{
							label: 'Continue',
							action: function (dialogRef) {
								dialogRef.close();
							},
						},
					],
				});
			}});
		return false;
	});
});