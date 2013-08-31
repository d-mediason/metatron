$ ()->
  writeChildren = (base, children)->
    $.each children, (childUri, childChildren)->
      childBase = $('<div class="child"></div>').text(childUri).appendTo(base)
      writeChildren childBase, childChildren

  writeParents = (base, parents)->
    $.each parents, (parentUri, parentParents)->
      parentBase = $('<div class="parent"></div>').text(parentUri).appendTo(base)
      writeChildren parentBase, parentParents



  uri = location.search.match(/uri=([^&]+)/)[1]
  $.get '/api/tree', { uri: uri }, (resp)->
    console.log resp
    $('body').empty()
    base = $('<div class="base"></div>').text(resp.base).appendTo('body')
    writeChildren base, resp.children
    writeParents base, resp.parents

