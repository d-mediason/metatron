package controllers

import play.api.mvc.{Action, Controller}
import play.api.libs.json.{JsNull, JsValue, Json}

object ApiController extends Controller {
  def tree = Action { implicit request =>
    val contentsTree: JsValue = Json.obj(
      "status" -> "ok",
      "base" -> "https://twitter.com/AmberFate/status/372335254515625985/",
      "parents" -> Json.obj(
        "http://portal.nifty.com/kiji/130801161315_1.htm" -> Json.obj(
          "http://www.google.co.jp" -> Json.obj()
        )
      ),
      "children" -> Json.obj(
        "http://alfalfalfa.com/archives/6764488.html" -> Json.obj()
      )
    )
    Ok(contentsTree)
  }
}
