import React from 'react'
import {Link} from 'react-router-dom'

const MainBodyComp =( {post, id , title}) => {
    
  return (
    <div className="flex flex-col  bg-orange-700">
            <h1 className='self-center my-4'>{title}</h1>
            <textarea name="" id="" rows = "15"cols="30" 
            className='bg-white self-center w-11/12' readOnly  disabled
            value={post}
            ></textarea>
            <button className=' self-end mr-12'> <Link to= {`/Post/${id}`}> Read More</Link></button>
          </div>
  )
}

export default MainBodyComp