package com.iscsi.convert

/**
  * Created by hkatz on 6/15/16.
  */
object Conversions {
  private def bin2int(binstr: String): Long = {
    val regBin = """([01]+)""".r
    try {
      binstr match {
        case regBin(bin) =>
          bin.map(x => Integer.parseInt(x.toString, 2)).
          map(_.toLong).
          foldLeft(0l){case(acc, elt) => acc * 2l + elt}
        case _ => throw new Exception("Invalid format for binary")
      }
    } catch {
      case m: MatchError => throw new Exception("Invalid binary number")
    }
  }

  private def hex2int(hexstr: String): Long = {
    val regHex = """(0x)*([0123456789aAbBcCdDeEfF]+)""".r
    try {
      hexstr match {
        case regHex(_, hex) =>
          hex.map(x => Integer.parseInt(x.toString, 16)).
          map(_.toLong).
          foldLeft(0l){case(acc, elt) => acc * 16l + elt}
        case _ => throw new Exception("Invalid format for hex")
      }
    } catch {
      case m: MatchError => throw new Exception("Invalid hex number")
    }
  }

  def hex2bin(hexStr: String): String = hex2int(hexStr).toBinaryString

  def bin2hex(binStr: String): String = bin2int(binStr).toHexString
}