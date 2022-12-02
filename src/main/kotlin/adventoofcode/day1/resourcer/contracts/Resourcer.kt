package adventoofcode.day1.resourcer.contracts

import java.net.URI

interface Resourcer {

    fun getResourceURI(path: String): URI
}