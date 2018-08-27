package com.view.zhaojian.view.view;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;


/**
 * 表情，特殊字符去除输入框
 */
public class FilterEditText extends EditText {
    private int cursorPos = 0;//输入表情前的光标位置
    private String inputAfterText = "";//输入表情前EditText中的文本
    private boolean resetText = false;//是否重置了EditText的内容
    private int maxLenth = 500;//最大限值

    private Context mContext;

    public FilterEditText(Context context) {
        super(context);
        this.mContext = context;
        initEditText();
    }

    public FilterEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initEditText();
    }

    public FilterEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initEditText();
    }

    // 初始化edittext 控件
    private void initEditText() {
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int before, int count) {
                if (!resetText) {
                    cursorPos = getSelectionEnd();
                    //这里用s.toString()而不直接用s是因为如果用s，
                    // 那么，inputAfterText和s在内存中指向的是同一个地址，s改变了，
                    // inputAfterText也就改变了，那么表情过滤就失败了
                    inputAfterText = s.toString();
                }

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    if (!resetText) {
                        if(before != 0){
                            return;
                        }
                        if (count >= 2) {//表情符号的字符长度最小为2
                            CharSequence input = s.subSequence(cursorPos, cursorPos + count);
                            //TODO 表情和特殊符号筛选
                            if (containsEmoji(input.toString())) {
                                resetText = true;

                                //是表情符号就将文本还原为输入表情符号之前的内容
                                setText(inputAfterText);
                                CharSequence text = getText();
                                if (text instanceof Spannable) {
                                    Spannable spanText = (Spannable) text;
                                    Selection.setSelection(spanText, text.length());
                                }
                            }
                        }
                    } else {
                        resetText = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String str = editable.toString();
                if (str.length()>maxLenth){
                    setText(str.substring(0,maxLenth));
                }
            }
        });
    }


    /**
     * 检测是否有emoji表情
     *
     * @param source
     * @return
     */
    public static boolean containsEmoji(String source) {
        int len = source.length();
        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);
            if (!isEmojiCharacter(codePoint)) { //如果不能匹配,则该字符是Emoji表情
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否是Emoji
     *
     * @param codePoint 比较的单个字符
     * @return
     */
    private static boolean isEmojiCharacter(char codePoint) {
        return (codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA) ||
                (codePoint == 0xD) || ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) ||
                ((codePoint >= 0xE000) && (codePoint <= 0xFFFD)) || ((codePoint >= 0x10000)
                && (codePoint <= 0x10FFFF));
    }

    public int getMaxLenth() {
        return maxLenth;
    }

    public void setMaxLenth(int maxLenth) {
        this.maxLenth = maxLenth;
    }
}
