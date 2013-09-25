package demo


import scala.beans.BeanProperty

/**
 * todo
 */
case class Customer(@BeanProperty var name: String,
                     @BeanProperty var age: Int,
                     @BeanProperty var pass: Boolean) {

}

