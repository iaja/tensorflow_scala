/* Copyright 2017, Mageswaran.D (mageswaran1989@gmail.com). All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.platanios.tensorflow.examples

import com.typesafe.scalalogging.Logger
import org.platanios.tensorflow.api._
import org.platanios.tensorflow.api.ops.variables.ConstantInitializer
import org.slf4j.LoggerFactory

/**
  * Created by Mageswaran.D (mageswaran1989@gmail.com) on 19/8/17.
  */
object Tensors {

  private[this] val logger = Logger(LoggerFactory.getLogger("Examples / Linear Regression"))

  def main(args: Array[String]): Unit = {

    //Get graph handle with the tf.Session()
    val session = tf.Session()

    //TensorFlow has built in function to create tensors for use in variables.
    // For example, we can create a zero filled tensor of predefined shape using the tf.zeros() function as follows.
    val myTensor = tf.zeros(Shape(3, 4), INT32)

    //We can evaluate tensors with calling a run() method on our session.
    println("myTensor info: ", session.run(fetches = myTensor).toString)
    println("Output of myTensor: ", session.run(fetches = myTensor).summarize())


    //TensorFlow algorithms need to know which objects are variables and which are constants.
    val myVar = tf.variable("myVar", FLOAT32, Shape(3, 4), tf.zerosInitializer)

    //Note that you can not run sess.run(my_var), this would result in an error.
    // Because TensorFlow operates with computational graphs, we have to create a variable
    // intialization operation in order to evaluate variables.
    // We will see more of this later on. For this script,
    // we can initialize one variable at a time by calling the variable method my_var.initializer.
    session.run(targets = myVar.initializer)
    println("Output of myVar: ", session.run(fetches = myVar.value).summarize())


    val fillVar = tf.variable("fillVar", FLOAT32,  Shape(4,4), initializer=ConstantInitializer(-1))
    session.run(targets = fillVar.initializer)
    println("Output of fillVar: ", session.run(fetches = fillVar.value).summarize())
  }
}
