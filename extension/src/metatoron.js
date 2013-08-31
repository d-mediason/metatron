chrome.tabs.getSelected(null, function(tab) {
	var siteTitle = tab.title;
	$('#pageUrl').text(tab.url);
});
$(function(){
	$('button#submit').on('click', function() {
		var siteUrl = $('#pageUrl').text();
		var srcUrl = $('#srcUrl').val();
		alert(siteUrl + ' ' + srcUrl);
	});
});
