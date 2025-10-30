package dev.vrba.brunointellij.file

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import dev.vrba.brunointellij.language.BrunoLanguage

class BrunoFile(fileViewProvider: FileViewProvider) : PsiFileBase(fileViewProvider, BrunoLanguage.INSTANCE) {
    override fun getFileType(): FileType {
        return BrunoFileType()
    }

    override fun toString(): String {
        return "Bruno file"
    }
}