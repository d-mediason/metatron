package models.tree

import com.redis.RedisClient
import play.api.libs.json.{JsObject, Json}

class TreeRepository {
  val redis = new RedisClient("f.morikuma.org", 6379)

  def register(parent: String, child: String) = {

  }

  private def registerParent(parent: String, child: String) = {
    redis.get(parent).map{jsonString =>
      val deta = Json.parse(jsonString).as[Map[String, List[String]]]
      deta.get("children").map(_.::(List(child)))
    }
  }
}
