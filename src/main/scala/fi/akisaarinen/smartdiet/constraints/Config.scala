/*
 * This file is part of SmartDiet.
 *
 * Copyright (C) 2011, Aki Saarinen.
 *
 * SmartDiet was developed in affiliation with Aalto University School
 * of Science, Department of Computer Science and Engineering. For
 * more information about the department, see <http://cse.aalto.fi/>.
 *
 * SmartDiet is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * SmartDiet is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with SmartDiet.  If not, see <http://www.gnu.org/licenses/>.
 */

package fi.akisaarinen.smartdiet.constraints

import io.Source
import net.liftweb.json.{DefaultFormats, parse}

object Config {
  case class SourceConfig(sdkClassFilePath: String, apps: List[Application])
  case class Application(name: String,
                         appPath: String,
                         libPath: Option[String] = None,
                         appSrcPath: Option[String] = None)

  def loadConfig(filename: String): SourceConfig = {
    val data = Source.fromFile(filename).getLines().mkString("\n")
    val json = parse(data)
    implicit val formats = DefaultFormats
    json.extract[SourceConfig]
  }
}