package controllers

import play.api.mvc.{Controller, Action}
import play.api.libs.json.{JsNull, JsValue, Json}
import com.redis.RedisClient

object ApiController extends Controller {
  val redis = new RedisClient("f.morikuma.org", 6379)
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
  def register = Action { request =>
    val response = Json.obj(
      "status" -> "ok",
      "param" -> request.body.toString
    )
    Ok(response)
  }
  def registerPost = Action { request =>
    request.body.asFormUrlEncoded match {
      case None => BadRequest(Json.obj("status" -> "ng"))
      case Some(req: Map[String, Seq[String]]) => {
        case param if req.exists(n => n._1 == "parent") && req.exists(m => m._1 == "child") => {
          val parent = req.get("parent")
          val child = req.get("child")

        }
        case _ => BadRequest(Json.obj("status" -> "ng"))
      }
    }

    Ok
  }
}
