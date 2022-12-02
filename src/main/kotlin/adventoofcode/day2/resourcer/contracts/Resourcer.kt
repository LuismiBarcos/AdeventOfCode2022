package adventoofcode.day2.resourcer.contracts

import java.net.URI

interface Resourcer {

    fun getResourceURI(path: String): URI
}