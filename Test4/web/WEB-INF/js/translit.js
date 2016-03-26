function toTranslit(){
    var text = document.getElementById('name').value;
    var transl = {
        'А':'A','а':'a','Б':'B','б':'b','В':'V','в':'v','Г':'G','г':'g',
        'Д':'D','д':'d','Е':'E','е':'e','Ё':'Yo','ё':'yo','Ж':'Zh','ж':'zh',
        'З':'Z','з':'z','И':'I','и':'i','Й':'Y','й':'y','К':'K','к':'k',
        'Л':'L','л':'l','М':'M','м':'m','Н':'N','н':'n','О':'O','о':'o',
        'П':'P','п':'p','Р':'R','р':'r','С':'S','с':'s','Т':'T','т':'t',
        'У':'U','у':'u','Ф':'F','ф':'f','Х':'Kh','х':'kh','Ц':'Ts','ц':'ts',
        'Ч':'Ch','ч':'ch','Ш':'Sh','ш':'sh','Щ':'Sch','щ':'sch','Ъ':'"','ъ':'"',
        'Ы':'Y','ы':'y','Ь':"'",'ь':"'",'Э':'E','э':'e','Ю':'Yu','ю':'yu',
        'Я':'Ya','я':'ya'
    }
    var result = '';
    for(i = 0; i < text.length; i++) {
        if(transl[text[i]] != undefined) {
            result += transl[text[i]];
        }
        else {
            result += text[i];
        }
    }
    document.getElementById('alias').value = result;
    document.getElementById('reverse').value = result.split("").reverse().join("");;
}
