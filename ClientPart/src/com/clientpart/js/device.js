function Device(obj) {
    var index = obj.classname.lastIndexOf('.');
    var name = obj.classname.substring(index+1);
    this.name = name;
    this.status ="off";

    this.turn = function() {
        if (this.status == "off") {
            this.status = "on";
        }else{
            this.status ="off"
        }
    }

    this.getMessage = function() {
        return this.name + ":I am turned " + this.status +"!";

    }

}
