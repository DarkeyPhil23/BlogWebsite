import React from 'react'
import Default from '../../assets/images/Default.jpg'

const ProfileImgComp = ({userPic}) => {
  return (
    <>
    {
        <>
        {(() => {
          if (userPic== 'default') {
            return (
             <img src={Default} alt=""  className='mr-2 rounded-full w-10' />
            )
          } else if (userPic == 'user') {
            return (
              <div>otherCase</div>
            )
          } 
        })()}
      </>
        
    }
    </>
  )
}

export default ProfileImgComp