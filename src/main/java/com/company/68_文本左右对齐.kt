package com.company


/**
 * @author guuguo
 * @see <a href="https://leetcode-cn.com/problems/text-justification/">leetcode链接</a>*/
fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
    ///当前行开始排序的文字索引
    var currentIndex = 0
    ///当前行文字总长度
    var currentLineWordLength=0;
    var currentLineSpaceLength=0;
    var currentWordSpaceLength=0;
    ///当前行字符串
    val sb=StringBuilder()
    val resList= mutableListOf<String>()
    for(i in words.indices){
        currentLineWordLength+= words[i].length
        ///后面已经没有单词了  或者下个单词已经放不下这一行
        if(i==words.lastIndex || currentLineWordLength+words[i+1].length+(i-currentIndex+1) > maxWidth )
        {
            sb.append(words[currentIndex])
            if (i - currentIndex > 0) {
                currentLineSpaceLength=maxWidth-currentLineWordLength
                for (wordIndex in currentIndex + 1 .. i) {
                    if (i==words.lastIndex)
                        sb.append(' ')
                    else {
                        currentWordSpaceLength= currentLineSpaceLength/(i-wordIndex+1) + (if(currentLineSpaceLength%(i-wordIndex+1)==0) 0 else 1)
                        currentLineSpaceLength -= currentWordSpaceLength
                        repeat(currentWordSpaceLength) {
                            sb.append(' ')
                        }
                    }
                    sb.append(words[wordIndex])
                }
            }
            ///后缀补满空格
            repeat(maxWidth-sb.length){
                sb.append(' ')
            }
            resList.add(sb.toString())
            sb.clear()
            currentLineWordLength=0
            currentIndex=i+1
        }
    }
    return resList
}