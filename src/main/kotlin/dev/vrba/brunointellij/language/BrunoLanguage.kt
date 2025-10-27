package dev.vrba.brunointellij.language

import com.intellij.lang.Language

class BrunoLanguage : Language("Bruno") {
    companion object {
        val INSTANCE = BrunoLanguage()
    }
}