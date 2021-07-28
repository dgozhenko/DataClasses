/*
 * Copyright (c) 2021 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * This project and source code may use libraries or frameworks that are
 * released under various Open-Source licenses. Use of those libraries and
 * frameworks are governed by their own individual licenses.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.android.paddockbuilder.repository

object Drivers {

  val LewisHamilton: Driver = Driver(
      id = "44-lh",
      firstName = "Sir Lewis",
      lastName = "Hamilton",
      currentTeamId = "mercedes",
      nationality = "British",
      number = 44,
  )

  val ValtteriBottas: Driver = Driver(
      id = "77-vb",
      firstName = "Valtteri",
      lastName = "Bottas",
      currentTeamId = "mercedes",
      nationality = "Finnish",
      number = 77,
  )

  val MaxVerstappen: Driver = Driver(
      id = "33-mv",
      firstName = "Max",
      lastName = "Verstappen",
      currentTeamId = "redbull",
      nationality = "Dutch",
      number = 33,
  )

  val SergioPerez: Driver = Driver(
      id = "11-checo",
      firstName = "Sergio",
      lastName = "Perez",
      currentTeamId = "redbull",
      nationality = "Mexican",
      number = 11,
  )

  val DanielRicciardo: Driver = Driver(
      id = "3-dani-ric",
      firstName = "Daniel",
      lastName = "Ricciardo",
      currentTeamId = "mclaren",
      nationality = "Australian",
      number = 3,
  )

  val LandoNorris: Driver = Driver(
      id = "4-lando",
      firstName = "Lando",
      lastName = "Norris",
      currentTeamId = "mclaren",
      nationality = "British",
      number = 4,
  )

  val SebastianVettel: Driver = Driver(
      id = "5-seb-vet",
      firstName = "Sebastian",
      lastName = "Vettel",
      currentTeamId = "astonmartin",
      nationality = "German",
      number = 5,
  )

  val LanceStroll: Driver = Driver(
      id = "18-lance-stroll",
      firstName = "Lance",
      lastName = "Stroll",
      currentTeamId = "astonmartin",
      nationality = "Canadian",
      number = 18,
  )

  val FernandoAlonso: Driver = Driver(
      id = "14-fer-alonso",
      firstName = "Fernando",
      lastName = "Alonso",
      currentTeamId = "alpine",
      nationality = "Spanish",
      number = 14,
  )

  val EstebanOcon: Driver = Driver(
      id = "31-ocon",
      firstName = "Esteban",
      lastName = "Ocon",
      currentTeamId = "alpine",
      nationality = "French",
      number = 31,
  )

  val CharlesLeclerc: Driver = Driver(
      id = "16-lec",
      firstName = "Charles",
      lastName = "Leclerc",
      currentTeamId = "ferrari",
      nationality = "Monegasque",
      number = 16,
  )

  val CarlosSainz: Driver = Driver(
      id = "55-sainz",
      firstName = "Carlos",
      lastName = "Sainz",
      currentTeamId = "ferrari",
      nationality = "Spanish",
      number = 55,
  )

  val PierreGasly: Driver = Driver(
      id = "10-pi-gas",
      firstName = "Pierre",
      lastName = "Gasly",
      currentTeamId = "alphatauri",
      nationality = "French",
      number = 10,
  )

  val YukiTsunoda: Driver = Driver(
      id = "22-yu-tsu",
      firstName = "Yuki",
      lastName = "Tsunoda",
      currentTeamId = "alphatauri",
      nationality = "Japanese",
      number = 22,
  )

  val KimiRaikkonen: Driver = Driver(
      id = "7-ice-man",
      firstName = "Kimi",
      lastName = "Raikkonen",
      currentTeamId = "alfaromeo",
      nationality = "Finnish",
      number = 7,
  )

  val AntonioGiovinazzi: Driver = Driver(
      id = "99-gio",
      firstName = "Antonio",
      lastName = "Giovinazzi",
      currentTeamId = "alfaromeo",
      nationality = "Italian",
      number = 99,
  )

  val MickSchumacher: Driver = Driver(
      id = "47-schumacher",
      firstName = "Mick",
      lastName = "Schumacher",
      currentTeamId = "haas",
      nationality = "German",
      number = 47,
  )

  val NikitaMazepin: Driver = Driver(
      id = "9-maze",
      firstName = "Nikita",
      lastName = "Mazepin",
      currentTeamId = "haas",
      nationality = "Russian",
      number = 9,
  )

  val GeorgeRussell: Driver = Driver(
      id = "63-g-rus",
      firstName = "George",
      lastName = "Russell",
      currentTeamId = "williams",
      nationality = "British",
      number = 63,
  )

  val NicholasLatifi: Driver = Driver(
      id = "6-nic-lat",
      firstName = "Nicholas",
      lastName = "Latifi",
      currentTeamId = "williams",
      nationality = "Canadian",
      number = 6,
  )

  val all: List<Driver> = listOf(
      LewisHamilton,
      ValtteriBottas,
      MaxVerstappen,
      SergioPerez,
      LanceStroll,
      SebastianVettel,
      DanielRicciardo,
      LandoNorris,
      CharlesLeclerc,
      CarlosSainz,
      FernandoAlonso,
      EstebanOcon,
      PierreGasly,
      YukiTsunoda,
      KimiRaikkonen,
      AntonioGiovinazzi,
      MickSchumacher,
      NikitaMazepin,
      GeorgeRussell,
      NicholasLatifi,
  )
}

@Suppress("MemberVisibilityCanBePrivate")
object Constructors {

  val Mercedes: Constructor = Constructor(
      id = "mercedes",
      name = "Mercedes-AMG",
      drivers = listOf(Drivers.LewisHamilton, Drivers.ValtteriBottas),
  )

  val RedBull: Constructor = Constructor(
      id = "redbull",
      name = "Red Bull",
      drivers = listOf(Drivers.MaxVerstappen, Drivers.SergioPerez),
  )

  val McLaren: Constructor = Constructor(
      id = "mclaren",
      name = "McLaren",
      drivers = listOf(Drivers.DanielRicciardo, Drivers.LandoNorris),
  )

  val AstonMartin: Constructor = Constructor(
      id = "astonmartin",
      name = "Aston Martin",
      drivers = listOf(Drivers.SebastianVettel, Drivers.LanceStroll),
  )

  val Alpine: Constructor = Constructor(
      id = "alpine",
      name = "Alpine",
      drivers = listOf(Drivers.FernandoAlonso, Drivers.EstebanOcon),
  )

  val Ferrari: Constructor = Constructor(
      id = "ferrari",
      name = "Ferrari",
      drivers = listOf(Drivers.CharlesLeclerc, Drivers.CarlosSainz),
  )

  val AlphaTauri: Constructor = Constructor(
      id = "alphatauri",
      name = "AlphaTauri",
      drivers = listOf(Drivers.PierreGasly, Drivers.YukiTsunoda),
  )

  val AlfaRomeo: Constructor = Constructor(
      id = "alfaromeo",
      name = "Alfa Romeo",
      drivers = listOf(Drivers.KimiRaikkonen, Drivers.AntonioGiovinazzi),
  )

  val Haas: Constructor = Constructor(
      id = "haas",
      name = "Haas",
      drivers = listOf(Drivers.MickSchumacher, Drivers.NikitaMazepin),
  )

  val Williams: Constructor = Constructor(
      id = "williams",
      name = "Williams",
      drivers = listOf(Drivers.GeorgeRussell, Drivers.NicholasLatifi),
  )

  val all: List<Constructor> = listOf(
      Mercedes,
      RedBull,
      McLaren,
      AstonMartin,
      Alpine,
      Ferrari,
      AlphaTauri,
      AlfaRomeo,
      Haas,
      Williams
  )
}