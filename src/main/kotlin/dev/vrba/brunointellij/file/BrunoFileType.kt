package dev.vrba.brunointellij.file

import com.intellij.openapi.fileTypes.LanguageFileType
import dev.vrba.brunointellij.language.BrunoLanguage
import javax.swing.Icon

class BrunoFileType : LanguageFileType(BrunoLanguage.INSTANCE) {

    override fun getName(): String {
        return "Bruno"
    }

    override fun getDescription(): String {
        return "Bruno API file"
    }

    override fun getDefaultExtension(): String {
        return "bru"
    }

    override fun getIcon(): Icon {
        return BrunoIcons.FILE
    }
}