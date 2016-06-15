package com.iscsi

import com.iscsi.convert.Conversions
import org.scalatest.{Matchers, FlatSpec}

class ConversionTest extends FlatSpec with Matchers {
  "Hex" should "convert to Bin" in {
    val hex2BinMap = Map("0xCAFEbabe" -> "11001010111111101011101010111110",
      "0xCaFeBaBe" -> "11001010111111101011101010111110",
      "CaFeBaBE" -> "11001010111111101011101010111110",
      "CafeOOPS" -> "BAD")
    hex2BinMap.foreach{case(in, out) =>
      val outputStr =
        try {
          Conversions.hex2bin(in)
      } catch {
        case e: Exception => "BAD"
      }
      outputStr should be(out)
    }
  }

  "Bin" should "convert to Hex" in {
    val bin2HexMap = Map("1010101010111111110000000111111" -> "0x555fe03f",
      "1111110001111110000111111100000" -> "0x7e3f0fe0",
      "1111111111111199111111111111111" -> "BAD")
    bin2HexMap.foreach{case(in, out) =>
      val outputStr =
        try {
          "0x" + Conversions.bin2hex(in)
        } catch {
          case e: Exception => "BAD"
        }
      outputStr should be(out)
    }
  }  



}
