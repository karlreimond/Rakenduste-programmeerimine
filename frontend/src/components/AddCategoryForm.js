import React from 'react'
import {useRef} from 'react'

function AddCategoryForm(props) {

    const nameRef = useRef()
    const typeRef = useRef()

    function formSubmitHandler(e) {
        e.preventDefault();

        const category = {
            name: nameRef.current.value,
            categoryType: typeRef.current.value
        }

        props.onAddCategory(category)
    }

    return (
        <form onSubmit={formSubmitHandler}>
            <label htmlFor="cname">Kategooria nimetus</label><br/>
            <input type="text" id="cname" name="cname" required ref={nameRef}/><br/>
            <label htmlFor="type">Kategooria valik</label><br/>
            <select name="type" id="type" required ref={typeRef}>
                <option value="BASIC" default>BASIC</option>
                <option value="ECONOMY">ECONOMEY</option>
                <option value="PREMIUM">PREMIUM</option>
            </select><br/>
            <button>Lisa</button>
        </form>
    )
}

export default AddCategoryForm