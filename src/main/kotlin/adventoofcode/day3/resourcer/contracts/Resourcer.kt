package adventoofcode.day3.resourcer.contracts

import java.net.URI

interface Resourcer {

    fun getResourceURI(path: String): URI
}