package scorex.core.transaction

import scorex.core.{EphemerealNodeViewModifier, NodeViewModifier}
import scorex.core.NodeViewModifier._
import scorex.core.crypto.hash.FastCryptographicHash
import scorex.core.transaction.box.proposition.Proposition


/**
  * A transaction is an atomic state modifier
  */

abstract class Transaction[P <: Proposition] extends EphemerealNodeViewModifier {
  override val modifierTypeId: Byte = Transaction.ModifierTypeId

  val messageToSign: Array[Byte]

  override lazy val id: ModifierId = FastCryptographicHash(messageToSign)
}


object Transaction {
  val ModifierTypeId: ModifierTypeId = 2: Byte
  type TransactionId = NodeViewModifier.ModifierId
}