package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("test"))
  }

  def tree(id: String) = Action {
    Ok(views.html.tree(id))
  }
}


