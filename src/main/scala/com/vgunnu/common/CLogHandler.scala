package com.vgunnu.common

import org.apache.log4j.Logger

object CLogHandler extends Serializable {
  @transient lazy val log =
    Logger.getLogger(getClass.getName)
}