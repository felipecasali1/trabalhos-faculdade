import React from "react"
import { useState } from "react"
import { HiSun } from "react-icons/hi";
import { HiMoon } from "react-icons/hi";
import "./index.css"

export default function MeuComponente() {
    const [buttonCount, setButtonCount] = useState(0);
    const [text, setText] = useState("Informe seu nome: ");
    const [theme, setTheme] = useState(true);

    return (
        <div id="display" className={theme ? "day" : "night"}>
            <div id="content">
                <div id="buttons">
                    <div id="buttonClick" className={theme ? "day" : "night"}>
                        <button onClick={() => setButtonCount(buttonCount+1)}>{buttonCount} clicks</button>
                    </div>
                    <div id="themeButton" className={theme ? "day" : "night"}>
                        <button onClick={() => {theme ? setTheme(false) : setTheme(true)}}>
                            {theme ? <HiMoon size={25}/> : <HiSun size={25}/>}
                        </button>
                    </div>
                </div>
                <div id="input" >
                    <p>{text}</p>
                    <input type="text" className={theme ? "day" : "night"} onChange={
                        (e) => {e.target.value.trim() === "" ? setText("Informe seu nome: ") : setText("Seja bem-vindo, " + e.target.value + "!")}
                    }/>
                </div>
            </div>
        </div>
    )
}
