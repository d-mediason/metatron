$ ->
  writeChildren = (children)->
    $ul = $('<ul></ul>')
    $.each children, (childUri, childChildren)->
      $('<li class="child"></li>').text(childUri).append(writeChildren childChildren).appendTo($ul)
    $ul

  writeParents = (parents)->
    $ul = $('<ul></ul>')
    $.each parents, (parentUri, parentParents)->
      $('<li class="parent"></li>').text(parentUri).append(writeChildren parentParents).appendTo($ul)
    $ul



  uri = location.search.match(/uri=([^&]+)/)[1]
  $.get '/api/tree', { uri: uri }, (resp)->
    console.log resp
    $('body').empty()

    $('<div class="base"></div>').text(resp.base).appendTo('body')
      .append("<h3>parents</h3>")
      .append(writeParents resp.parents)
      .append("<h3>children</h3>")
      .append(writeChildren resp.children)

