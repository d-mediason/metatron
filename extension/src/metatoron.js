chrome.tabs.getSelected(null, function(tab) {
	$('#pageUrl').text('<a href="http://f.morikuma.org/tree?uri='+tab.url+'" target="_blank">'+tab.url+'</a>');
	$('#pageTitle').text(tab.title);
});
$(function(){
	$('button#submit').on('click', function() {
		var pageTitle = $('#pageTitle').text();
		var pageUrl = $('#pageUrl').text();
		var srcUrl = $('#srcUrl').val();
		$.post('http://f.morikuma.org/api/register', { child:pageUrl, parent:srcUrl}, function(resp) {
			if (resp.status === 'ok') {
				alert('登録しました');
			}
		});
	});
});
