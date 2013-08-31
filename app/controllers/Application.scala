package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("test"))
  }

  def tree(uri: String) = Action {
    val encode_uri = java.net.URLEncoder.encode(uri, "UTF-8")
    Ok(views.html.tree(encode_uri))
  }
}


