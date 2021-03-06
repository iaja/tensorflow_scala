/* Copyright 2017, Emmanouil Antonios Platanios. All Rights Reserved.
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

package org.platanios.tensorflow.api.learn.layers

import org.platanios.tensorflow.api._
import org.platanios.tensorflow.api.learn.{Mode, TRAINING, layers}
import org.platanios.tensorflow.api.ops
import org.platanios.tensorflow.api.ops.NN.{CNNDataFormat, PaddingMode}
import org.platanios.tensorflow.api.ops.Output
import org.platanios.tensorflow.api.ops.variables.{Initializer, RandomNormalInitializer}

/**
  * @author Emmanouil Antonios Platanios
  */
object NN {
  private[layers] trait API {
    type Softmax = layers.Softmax
    type LogSoftmax = layers.LogSoftmax
    type Dropout = layers.Dropout
    type Conv2D = layers.Conv2D
    type MaxPool = layers.MaxPool

    val Softmax   : layers.Softmax.type    = layers.Softmax
    val LogSoftmax: layers.LogSoftmax.type = layers.LogSoftmax
    val Dropout   : layers.Dropout.type    = layers.Dropout
    val Conv2D    : layers.Conv2D.type     = layers.Conv2D
    val MaxPool   : layers.MaxPool.type    = layers.MaxPool
  }

  object API extends API
}

case class Softmax(override val variableScope: String)
    extends Layer[Output, Output](variableScope) {
  override val layerType: String = "Softmax"

  override protected def forward(input: Output, mode: Mode): LayerInstance[Output, Output] = {
    LayerInstance(input, ops.NN.softmax(input, name = variableScope))
  }
}

case class LogSoftmax(override val variableScope: String)
    extends Layer[Output, Output](variableScope) {
  override val layerType: String = "LogSoftmax"

  override protected def forward(input: Output, mode: Mode): LayerInstance[Output, Output] = {
    LayerInstance(input, ops.NN.logSoftmax(input, name = variableScope))
  }
}

case class Dropout(
    override val variableScope: String,
    keepProbability: Float,
    noiseShape: Shape = null,
    seed: Option[Int] = None
) extends Layer[Output, Output](variableScope) {
  override val layerType: String = s"Dropout[$keepProbability]"

  override protected def forward(input: Output, mode: Mode): LayerInstance[Output, Output] = {
    val output = mode match {
      case TRAINING =>
        val noise = if (noiseShape == null) null else noiseShape.toOutput()
        ops.NN.dropout(input, keepProbability, noise, seed, variableScope)
      case _ => input
    }
    LayerInstance(input, output)
  }
}

case class Conv2D(
    override val variableScope: String,
    filterShape: Shape,
    stride1: Long,
    stride2: Long,
    padding: PaddingMode,
    dataFormat: CNNDataFormat = CNNDataFormat.default,
    useCuDNNOnGPU: Boolean = true,
    weightsInitializer: Initializer = RandomNormalInitializer()
) extends Layer[Output, Output](variableScope) {
  override val layerType: String = s"Conv2D[${filterShape.asArray.mkString(",")}]"

  override protected def forward(input: Output, mode: Mode): LayerInstance[Output, Output] = {
    val weights = tf.variable("Weights", input.dataType, filterShape, weightsInitializer)
    val output = ops.NN.conv2D(input, weights, stride1, stride2, padding, dataFormat, useCuDNNOnGPU)
    LayerInstance(input, output, Set(weights))
  }
}

case class MaxPool(
    override val variableScope: String,
    windowSize: Seq[Long],
    stride1: Long,
    stride2: Long,
    padding: PaddingMode,
    dataFormat: CNNDataFormat = CNNDataFormat.default
) extends Layer[Output, Output](variableScope) {
  override val layerType: String = s"MaxPool[${windowSize.mkString(",")}]"

  override protected def forward(input: Output, mode: Mode): LayerInstance[Output, Output] = {
    val output = ops.NN.maxPool(input, windowSize, stride1, stride2, padding, dataFormat, variableScope)
    LayerInstance(input, output)
  }
}
