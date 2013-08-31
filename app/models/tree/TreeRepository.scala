package models.tree

import com.redis.RedisClient

class TreeRepository {
  val redis = new RedisClient("f.morikuma.org", 6379)

  def register(parent: String, child: String) = {

  }

  private def registerParent(parent: String) = {
    redis.get()
  }
}
